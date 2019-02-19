package DB;

import Entities.Address;
import Entities.AdvancedSearch;
import Entities.Form;
import Entities.FormFirebase;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FirebaseFunc {
    private FirebaseDatabase database;
    private DatabaseReference ref;
    private List<FormFirebase> FormList;

    private FirebaseFunc() {
        try {


            URL ur = new URL("file:///" + System.getProperty("user.dir") + "/src/main/resources/" + "soft-eng-ttb-firebase-adminsdk-zlciz-a2dfee347b.json");

            File file = new File(ur.toURI());
            FileInputStream serviceAccount = new FileInputStream(file);

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://soft-eng-ttb.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);

            this.database = FirebaseDatabase.getInstance();
            this.ref = database.getReference("forms");
            ref.orderByKey();

            //Listener for data sendback
            /*
            this.ref.setValue("I'm writing data", new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if (databaseError != null) {
                        System.out.println("Data could not be saved " + databaseError.getMessage());
                    } else {
                        System.out.println("Data saved successfully.");
                    }
                }
            });*/

            FormList = new ArrayList<>();
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    FormList.clear();
                    for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                        FormFirebase form = postSnapshot.getValue(FormFirebase.class);
                        FormList.add(form);
                        //Can do stuff here if I need to
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    System.out.println("The read failed: " + databaseError.getMessage());
                }
            });
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private static class SingletonHelper {
        private static final FirebaseFunc firebaseFunc = new FirebaseFunc();
    }

    public static FirebaseFunc getFirebaseFunc() {
        return SingletonHelper.firebaseFunc;
    }

    /**
     * Inserts a fully filled out form into the firebase database
     * @author Jordan
     * @param form A FormFirebase with all the info filled out to be inserted into the db
     */
    public void insertFormFirebase(FormFirebase form) {
        DatabaseReference newPostRef = ref.push();
        newPostRef.setValue(form, null);

        //Map<String, FormFirebase> forms = new HashMap<>();
        //forms.put("" + form.getTtbID(), form);
        //ref.setValueAsync(forms);
    }

    @SuppressWarnings( "deprecation" )
    public void insertDataFirebase() {
        long startTime = System.nanoTime();
        int fullCount = 0;
        try {
            //This is hardcoded, cause reasons
            CSVReader reader = new CSVReader(new FileReader("/Users/Jordan/Downloads/FirebaseData/ttbdata06.txt"), '\t');
            String[] record;
            while ((record = reader.readNext()) != null) {
                fullCount++;
                FormFirebase form = new FormFirebase();

                if (record[0].length() > 0) {
                    form.setTtbID(record[0]);
                } else {
                    form.setTtbID(null);
                }
                if (record[1].length() > 0) {
                    form.setRepID(record[1]);
                } else {
                    form.setRepID(null);
                }
                if (record[2].length() > 0) {
                    form.setClassType(record[2]);
                } else {
                    form.setClassType(null);
                }
                if (record[3].length() > 0) {
                    form.setOrigin(record[3]);
                } else {
                    form.setOrigin(null);
                }
                if (record[4].length() > 0) {
                    form.setBrewersPermit(record[4]);
                } else {
                    form.setBrewersPermit(null);
                }
                if (record[5].length() > 0) {
                    form.setSource(record[5]);
                } else {
                    form.setSource(null);
                }
                if (record[6].length() > 0) {
                    form.setSerialNumber(record[6]);
                } else {
                    form.setSerialNumber(null);
                }
                if (record[7].length() > 0) {
                    form.setAlcoholType(record[7]);
                } else {
                    form.setAlcoholType(null);
                }
                if (record[8].length() > 0) {
                    form.setBrandName(record[8]);
                } else {
                    form.setBrandName(null);
                }
                if (record[9].length() > 1) {
                    form.setFancifulName(record[9]);
                } else {
                    form.setFancifulName(null);
                }
                if (record[10].length() > 0) {
                    form.setAddressName(record[10]);
                } else {
                    form.setAddressName(null);
                }
                if (record[11].length() > 0) {
                    form.setAddressStreet(record[11]);
                } else {
                    form.setAddressStreet(null);
                }
                if (record[12].length() > 0) {
                    form.setAddressCity(record[12]);
                } else {
                    form.setAddressCity(null);
                }
                if (record[13].length() > 0) {
                    form.setAddressState(record[13]);
                } else {
                    form.setAddressState(null);
                }
                if (record[14].length() > 0) {
                    form.setAddressZip(record[14]);
                } else {
                    form.setAddressZip(null);
                }
                if (record[15].length() > 1) {
                    form.setGrapes(record[15]);
                } else {
                    form.setGrapes(null);
                }
                form.setOtherInfo(record[16] + " " + record[20]);
                if (record[17].length() > 0) {
                    form.setAlcoholContent(record[17]);
                } else {
                    form.setAlcoholContent(null);
                }
                if (record[18].length() > 1) {
                    form.setAppellation(record[18]);
                } else {
                    form.setAppellation(null);
                }
                if (record[19].length() > 1) {
                    form.setVintage(record[19]);
                } else {
                    form.setVintage(null);
                }
                if (record[21].length() > 0) {
                    form.setDateApproved(record[21]);
                } else {
                    form.setDateApproved(null);
                }
                if (record[22].length() > 0) {
                    form.setDateSubmitted(record[22]);
                } else {
                    form.setDateSubmitted(null);
                }
                if (record[23].length() > 0) {
                    form.setDateExpired(record[23]);
                } else {
                    form.setDateExpired(null);
                }
                if (record[24].length() > 0) {
                    form.setQualifications(record[24]);
                } else {
                    form.setQualifications(null);
                }

                insertFormFirebase(form);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println(fullCount);

        long endTime = System.nanoTime();
        System.out.println("Time in seconds of execution: " + ((endTime - startTime) / 1000000000));
    }

    public List<FormFirebase> searchFirebase(AdvancedSearch as) {
        List<FormFirebase> results = new ArrayList<>();
        //ref.orderByKey().
        return results;
    }

    public void testF() {
        System.out.println("Start Test");
        FormFirebase f = new FormFirebase();
        f.setTtbID("2");
        insertFormFirebase(f);
        System.out.println(FormList.size());
        for (int i = 0; i < FormList.size(); i++) {
            System.out.println(FormList.get(i).getTtbID());
        }
    }
}
