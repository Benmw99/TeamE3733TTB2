package DB;

import Entities.*;
import com.opencsv.CSVReader;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

//Class controlling inserting and updating in DB. Singleton class
public class DBInsert {
    private static DBInsert dbinsert; //TODO GET RID OF REPEATED CODE
    private static SessionFactory factory; //TODO ONE SESSIONFACTORY, INTERFACE THAT INCLUDES CLOSING METHOD

    private DBInsert() {
    }

    private static class SingletonHelper {
        private static final DBInsert dbinsert = new DBInsert();
    }

    static DBInsert getDbinsert() {
        return SingletonHelper.dbinsert;
    }

    public static void setFactory(SessionFactory factory) {
        DBInsert.factory = factory;
    }

    /**
     * Inserts a full form into the database. All relations must be set in the form
     * @author Jordan
     * @param form The fully completed form to be submitted. Approval should be set as a default incomplete.
     * @return The TTB ID of the form that was just inserted
     */
    public int insertForm(Form form) throws Exception{
        Session session = factory.openSession();
        Transaction tx = null;
        Integer formID = null;

        try {
            tx = session.beginTransaction();
            formID = (Integer) session.save(form);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            throw new Exception("Failed to insert form");
        } finally {
            session.close();
        }
        return formID;
    }

    /**
     * Inserts a company into the database.
     * @author Jordan
     * @param company A fully filled out company
     */
    public void insertCompany(Manufacturer company) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(company);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Inserts a rep into the database
     * @author Jordan
     * @param rep A fully filled out rep to be inserted
     */
    public void insertRep(Representative rep) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(rep);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Inserts an agent into the database
     * @author Jordan
     * @param agent The agent created and filled out with all info except id
     * @return The agent id of the newly inserted agent
     */
    public int insertAgent(Agent agent) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer agentID = null;
        try {
            tx = session.beginTransaction();
            agentID = (Integer) session.save(agent);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return agentID;
    }

    /**
     * Takes the form with a changed approval. This change of approval must be done by entities
     * @author Jordan
     * @param form The form that was updated
     */
    public void updateApproval(Form form) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //Merge is used as an update pretty much
            session.merge(form);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    /**
     * Inserts a labelImage into the database
     * @author Jordan
     * @param li The labelimage that you want to insert with everything except the id filled out
     */
    public void insertLabelImage(LabelImage li) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(li);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Inserts all the legacy data into the system, takes roughly 2 minutes to work. I'm sorry it's bad
     * @author Jordan
     */
    public void insertData() {
        long startTime = System.nanoTime();
        int fullCount = 0;
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            //Count of the number of forms to be actually sent to the database
            int count = 0;
            //This is hardcoded, cause reasons
            CSVReader reader = new CSVReader(new FileReader("/Users/Jordan/Downloads/ttbdata.txt"), '\t');
            String[] record;
            while ((record = reader.readNext()) != null) {
                count++;
                Form form = new Form();
                Approval app = new Approval();
                app.setPage1(ApprovalStatus.Complete);
                app.setPage2(ApprovalStatus.Complete);
                app.setPage3(ApprovalStatus.Complete);
                app.setPage4(ApprovalStatus.Complete);
                List<BrewersPermit> Brews = new ArrayList<>();
                BrewersPermit brew = new BrewersPermit();
                List<Address> Adds = new ArrayList<>();
                Address add = new Address();
                WineFormItems wineStuff = new WineFormItems();

                //form.setTtbID(Integer.parseInt(record[0]));
                form.setRepID(record[1]);
                brew.setBrewersNo(record[2]);
                brew.setPrimary(true);
                if (record[3].equals("Domestic")) {
                    form.setSource(false);
                } else {
                    form.setSource(true);
                }
                form.setSerialNumber(record[4]);
                if (record[5].equals("Wine")) {
                    form.setAlcoholType(AlcoholType.Wine);
                } else if (record[5].equals("Malt Beverage")) {
                    form.setAlcoholType(AlcoholType.MaltBeverage);
                } else {
                    form.setAlcoholType(AlcoholType.DistilledLiquor);
                }
                form.setBrandName(record[6]);
                if (record[7].length() > 1) {
                    form.setFancifulName(record[7]);
                } else {
                    form.setFancifulName(null);
                }
                if (record[8].length() > 87) {
                    add.setName(record[8].substring(0, 87));
                } else {
                    add.setName(record[8]);
                }
                if (record[9].length() > 49) {
                    add.setStreet(record[9].substring(0, 49));
                } else {
                    add.setStreet(record[9]);
                }
                add.setCity(record[10]);
                add.setState(record[11]);
                add.setZip(record[12]);
                if (form.getAlcoholType() == AlcoholType.Wine && record[13].length() > 1) {
                    wineStuff.setGrapeVarietal(record[13]);
                }
                //Trims to only numbers and decimals and then converts to a float
                if (record[15].length() > 0 && record[15].replaceAll("[^0-9.]", "").length() > 0) {
                    try {
                        form.setAlcoholContent(Float.parseFloat(record[15].replaceAll("[^0-9.]", "")));
                    } catch (NumberFormatException e) {
                        form.setAlcoholContent(0);
                    }
                } else {
                    form.setAlcoholContent(0);
                }
                if (form.getAlcoholType() == AlcoholType.Wine && record[16].length() > 1) {
                    if (record[16].length() > 79) {
                        wineStuff.setAppellation(record[16].substring(0, 79));
                    } else {
                        wineStuff.setAppellation(record[16]);
                    }
                }
                if (form.getAlcoholType() == AlcoholType.Wine && record[17].length() > 1) {
                    if (record[17].replaceAll("[^0-9]", "").length() > 0) {
                        wineStuff.setVintageYear(Integer.parseInt(record[17].replaceAll("[^0-9]", "")));
                    } else {
                        wineStuff.setVintageYear(0);
                    }
                }
                if (record[18].length() > 1) {
                    if ((record[18].length() + record[14].length()) > 255) {
                        form.setOtherInfo((record[14] + " " + record[18]).substring(0, 255));
                    } else {
                        form.setOtherInfo(record[14] + " " + record[18]);
                    }
                } else {
                    if (record[14].length() > 255) {
                        form.setOtherInfo(record[14].substring(0,255));
                    } else {
                        form.setOtherInfo(record[14]);
                    }
                }
                DateFormat format = new SimpleDateFormat("MM/dd/yy", Locale.ENGLISH);
                //Not sure if this is actually working
                app.setDateApproved(new java.sql.Date(format.parse(record[19]).getTime()));
                form.setDateSubmitted(new java.sql.Date(format.parse(record[20]).getTime()));
                if (record[21].length() > 1) {
                    app.setExpDate(new java.sql.Date(format.parse(record[21]).getTime()));
                }
                //Truncate if its over 600 characters
                if (record[22].length() > 599) {
                    app.setQualifications(record[22].substring(0, 599));
                } else {
                    app.setQualifications(record[22]);
                }

                form.setApprovalStatus(ApprovalStatus.Complete);
                form.setFormula(null);
                form.setApplicantName(null);
                if (form.getAlcoholType() == AlcoholType.Wine) {
                    form.setWineFormItems(wineStuff);
                } else {
                    form.setWineFormItems(null);
                }
                form.setPhoneNumber(null);
                form.setWorkingOn(0);
                form.setCompanyID(0);
                form.setEmail(null);
                app.setAgentApprovalName(null);
                Brews.add(brew);
                add.setMailing(true);
                Adds.add(add);
                form.setBrewersPermit(Brews);
                form.setAddress(Adds);
                form.setApproval(app);

                fullCount++;
                session.save(form);

                if (count % 20 == 0) {
                    session.flush();
                    session.clear();
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        tx.commit();
        session.close();
        System.out.println(fullCount);

        long endTime = System.nanoTime();
        System.out.println("Time in seconds of execution: " + ((endTime - startTime) / 1000000000));
    }
}
