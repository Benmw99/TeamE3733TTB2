package DB;

import Entities.*;
import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import com.opencsv.CSVReader;
import org.bson.Document;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MongoFunc {
    private static MongoFunc mongoFunc;
    private MongoDatabase database;

    private MongoFunc() {
        //MongoClientURI uri = new MongoClientURI(
         //       "mongodb+srv://TTBAgent:<>@experimental-cluster-eix1m.mongodb.net/test?retryWrites=true");

        //MongoClient mongoClient = new MongoClient(uri);
        MongoClient mongoClient = MongoClients.create("mongodb+srv://Admin:AdminTTB@experimental-cluster-eix1m.mongodb.net/test?retryWrites=true");
        //MongoCredential credential;
        //credential = MongoCredential.createCredential("Admin", "TTBForms",
        //        "AdminTTB".toCharArray());
        database = mongoClient.getDatabase("TTB");
        //database.createCollection("TTBForms");
    }

    private static class SingletonHelper {
        private static final MongoFunc mongoFunc = new MongoFunc();
    }

    static MongoFunc getMongoFunc() {
        return SingletonHelper.mongoFunc;
    }

    public void insertFormMongo(FormMongo form) {
        MongoCollection<Document> collection = database.getCollection("TTBForms");
        Document document = new Document("ttbID", form.getTtbID())
                .append("repID", form.getRepID())
                .append("brewersPermit", form.getBrewersPermit())
                .append("source", form.getSource())
                .append("serialNumber", form.getSerialNumber())
                .append("alcoholType", form.getAlcoholType())
                .append("brandName", form.getBrandName())
                .append("fancifulName", form.getFancifulName())
                .append("addressCity", form.getAddressCity())
                .append("addressState", form.getAddressState())
                .append("addressZip", form.getAddressZip())
                .append("addressStreet", form.getAddressStreet())
                .append("addressName", form.getAddressName())
                .append("otherInfo", form.getOtherInfo())
                .append("dateSubmitted", form.getDateSubmitted())
                .append("dateApproved", form.getDateApproved())
                .append("dateExpired", form.getDateExpired())
                .append("alcoholContent", form.getAlcoholContent())
                .append("classType", form.getClassType())
                .append("origin", form.getOrigin())
                .append("vintage", form.getVintage())
                .append("appellation", form.getAppellation())
                .append("grapes", form.getGrapes())
                .append("qualifications", form.getQualifications());
        collection.insertOne(document);
    }

    public void insertAllMongo(List<Document> docs) {
        MongoCollection<Document> collection = database.getCollection("TTBForms");
        collection.drop();
        database.createCollection("TTBForms");
        collection = database.getCollection("TTBForms");
        System.out.println("Inserting all forms to mongo");
        collection.insertMany(docs);
        System.out.println("Done inserting all forms to mongo");
    }

    public List<Form> getAllMongo() {
        List<Form> results = new ArrayList<>();
        MongoCollection<Document> collection = database.getCollection("TTBForms");
        List<Document> docs = new ArrayList<>();

        // Getting the iterable object
        FindIterable<Document> iterDoc = collection.find();

        // Getting the iterator
        Iterator it = iterDoc.iterator();

        while (it.hasNext()) {
            docs.add((Document)it.next());
        }
        ((MongoCursor) it).close();
        System.out.println(docs.size());
        for (int i = 0; i < docs.size(); i++) {
            FormMongo form = new FormMongo();
            form.setTtbID((String) docs.get(i).get("ttbID"));
            form.setRepID((String) docs.get(i).get("repID"));
            form.setBrewersPermit((String) docs.get(i).get("permit"));
            form.setSource((String) docs.get(i).get("source"));
            form.setSerialNumber((String) docs.get(i).get("serial"));
            form.setAlcoholType((String) docs.get(i).get("alcoholType"));
            form.setBrandName((String) docs.get(i).get("brandName"));
            form.setFancifulName((String) docs.get(i).get("fancifulName"));
            form.setAddressCity((String) docs.get(i).get("City"));
            form.setAddressState((String) docs.get(i).get("State"));
            form.setAddressZip((String) docs.get(i).get("Zip"));
            form.setAddressStreet((String) docs.get(i).get("Street"));
            form.setAddressName((String) docs.get(i).get("Name"));
            form.setOtherInfo((String) docs.get(i).get("otherInfo"));
            form.setDateSubmitted((String) docs.get(i).get("Submitted"));
            form.setDateApproved((String) docs.get(i).get("Approved"));
            form.setDateExpired((String) docs.get(i).get("Expired"));
            form.setAlcoholContent((String) docs.get(i).get("alcoholContent"));
            form.setClassType((String) docs.get(i).get("classType"));
            form.setOrigin((String) docs.get(i).get("origin"));
            form.setVintage((String) docs.get(i).get("vintage"));
            form.setAppellation((String) docs.get(i).get("appellation"));
            form.setGrapes((String) docs.get(i).get("grapes"));
            form.setQualifications((String) docs.get(i).get("qual"));

            results.add(formMongoToForm(form));
        }
        return results;
    }

    public Form formMongoToForm(FormMongo fm) {
        Form newForm = new Form();
        newForm.setRepID(fm.getRepID());
        newForm.brewersPermit.add(new BrewersPermit(fm.getBrewersPermit(), true));
        if (fm.getSource().equals("Domestic")) {
            newForm.setSource(false);
        } else {
            newForm.setSource(true);
        }
        newForm.setSerialNumber(fm.getSerialNumber());
        if (fm.getAlcoholType().equals("Wine")) {
            newForm.setAlcoholType(AlcoholType.Wine);
        } else if (fm.getAlcoholType().equals("Distilled Liquor")) {
            newForm.setAlcoholType(AlcoholType.DistilledLiquor);
        } else {
            newForm.setAlcoholType(AlcoholType.MaltBeverage);
        }
        try {
            newForm.setTtbID(Integer.parseInt(fm.getTtbID()));
        } catch (Exception e) {
            newForm.setTtbID(0);
        }
        newForm.setRepID(fm.getRepID());
        newForm.setSerialNumber(fm.getSerialNumber());
        newForm.setBrandName(fm.getBrandName());
        newForm.setFancifulName(fm.getFancifulName());
        List<Address> adds = new ArrayList<>();
        adds.add(new Address(fm.getAddressCity(), fm.getAddressState(), fm.getAddressZip(), fm.getAddressStreet(), fm.getAddressName(), true));
        newForm.setAddress(adds);
        newForm.setOtherInfo(fm.getOtherInfo());

        System.gc();
        return newForm;
    }

    public List<Form> searchMongo(AdvancedSearch as) {
        List<Form> info = getAllMongo();
        List<Form> results = new ArrayList<>();
        if (as.source != null) {
            for(Form fm : info) {
                if (as.source) {
                    if (fm.getSource()) {
                        results.add(fm);
                    } else {
                        results.add(fm);
                    }
                info.remove(fm);
                System.gc();
            }
        }
        }
        else if (as.serialNumber != null) {
            for(Form fm : info) {
                if (fm.getSerialNumber().equals(as.getSerialNumber())) {
                    results.add(fm);
                }
                info.remove(fm);
                System.gc();
            }
        }
        else if (as.alcoholType != null) {
            for(Form fm : info) {
                if (fm.getAlcoholType().equals(as.getAlcoholType().toString())) {
                    results.add(fm);
                }
                info.remove(fm);
                System.gc();
            }
        }
        else if (as.brandName != null) {
            for(Form fm : info) {
                if (fm.getBrandName().equals(as.getBrandName())) {
                    results.add(fm);
                }
                info.remove(fm);
                System.gc();
            }
        }
        else if (as.fancifulName != null) {
            for(Form fm : info) {
                if (fm.getFancifulName().equals(as.getFancifulName())) {
                    results.add(fm);
                }
                info.remove(fm);
                System.gc();
            }
        }
        else if (as.ttbID > 0) {
            for(Form fm : info) {
                if (fm.getTtbID() == as.getTtbID()) {
                    results.add(fm);
                }
                info.remove(fm);
                System.gc();
            }
        } else {
            for(Form fm : info) {
                results.add(fm);
                info.remove(fm);
                System.gc();
            }
        }
        return results;
    }


    @SuppressWarnings( "deprecation" )
    public void insertDataMongo() {
        long startTime = System.nanoTime();
        int fullCount = 0;
        List<Document> docs = new ArrayList<>();
        /*try {
            //This is hardcoded, cause reasons
            CSVReader reader = new CSVReader(new FileReader("/Users/Jordan/Downloads/FirebaseData/ttbdata06.txt"), '\t');
            String[] record;
            while ((record = reader.readNext()) != null) {
                fullCount++;
                FormMongo form = new FormMongo();

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

                //insertFormMongo(form);
                Document document = new Document("ttbID", form.getTtbID())
                        .append("repID", form.getRepID())
                        .append("permit", form.getBrewersPermit())
                        .append("source", form.getSource())
                        .append("serial", form.getSerialNumber())
                        .append("alcoholType", form.getAlcoholType())
                        .append("brandName", form.getBrandName())
                        .append("fancifulName", form.getFancifulName())
                        .append("City", form.getAddressCity())
                        .append("State", form.getAddressState())
                        .append("Zip", form.getAddressZip())
                        .append("Street", form.getAddressStreet())
                        .append("Name", form.getAddressName())
                        .append("otherInfo", form.getOtherInfo())
                        .append("Submitted", form.getDateSubmitted())
                        .append("Approved", form.getDateApproved())
                        .append("Expired", form.getDateExpired())
                        .append("alcoholContent", form.getAlcoholContent())
                        .append("classType", form.getClassType())
                        .append("origin", form.getOrigin())
                        .append("vintage", form.getVintage())
                        .append("appellation", form.getAppellation())
                        .append("grapes", form.getGrapes())
                        .append("qual", form.getQualifications());
                docs.add(document);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }*/
        try {
            //This is hardcoded, cause reasons
            CSVReader reader = new CSVReader(new FileReader("/Users/Jordan/Downloads/FirebaseData/ttbdata09.txt"), '\t');
            String[] record;
            while ((record = reader.readNext()) != null) {
                fullCount++;
                FormMongo form = new FormMongo();

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

                //insertFormMongo(form);
                Document document = new Document("ttbID", form.getTtbID())
                        .append("repID", form.getRepID())
                        .append("permit", form.getBrewersPermit())
                        .append("source", form.getSource())
                        .append("serial", form.getSerialNumber())
                        .append("alcoholType", form.getAlcoholType())
                        .append("brandName", form.getBrandName())
                        .append("fancifulName", form.getFancifulName())
                        .append("City", form.getAddressCity())
                        .append("State", form.getAddressState())
                        .append("Zip", form.getAddressZip())
                        .append("Street", form.getAddressStreet())
                        .append("Name", form.getAddressName())
                        .append("otherInfo", form.getOtherInfo())
                        .append("Submitted", form.getDateSubmitted())
                        .append("Approved", form.getDateApproved())
                        .append("Expired", form.getDateExpired())
                        .append("alcoholContent", form.getAlcoholContent())
                        .append("classType", form.getClassType())
                        .append("origin", form.getOrigin())
                        .append("vintage", form.getVintage())
                        .append("appellation", form.getAppellation())
                        .append("grapes", form.getGrapes())
                        .append("qual", form.getQualifications());
                docs.add(document);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        try {
            //This is hardcoded, cause reasons
            CSVReader reader = new CSVReader(new FileReader("/Users/Jordan/Downloads/FirebaseData/ttbdata12.txt"), '\t');
            String[] record;
            while ((record = reader.readNext()) != null) {
                fullCount++;
                FormMongo form = new FormMongo();

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

                //insertFormMongo(form);
                Document document = new Document("ttbID", form.getTtbID())
                        .append("repID", form.getRepID())
                        .append("permit", form.getBrewersPermit())
                        .append("source", form.getSource())
                        .append("serial", form.getSerialNumber())
                        .append("alcoholType", form.getAlcoholType())
                        .append("brandName", form.getBrandName())
                        .append("fancifulName", form.getFancifulName())
                        .append("City", form.getAddressCity())
                        .append("State", form.getAddressState())
                        .append("Zip", form.getAddressZip())
                        .append("Street", form.getAddressStreet())
                        .append("Name", form.getAddressName())
                        .append("otherInfo", form.getOtherInfo())
                        .append("Submitted", form.getDateSubmitted())
                        .append("Approved", form.getDateApproved())
                        .append("Expired", form.getDateExpired())
                        .append("alcoholContent", form.getAlcoholContent())
                        .append("classType", form.getClassType())
                        .append("origin", form.getOrigin())
                        .append("vintage", form.getVintage())
                        .append("appellation", form.getAppellation())
                        .append("grapes", form.getGrapes())
                        .append("qual", form.getQualifications());
                docs.add(document);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        insertAllMongo(docs);
        System.out.println(fullCount);
        long endTime = System.nanoTime();
        System.out.println("Time in seconds of execution: " + ((endTime - startTime) / 1000000000));
    }
}
