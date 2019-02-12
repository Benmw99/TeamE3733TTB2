import Entities.*;

import javafx.fxml.FXMLLoader;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Iterator;

public class main {
    //private static SessionFactory factory;

    public static void main(String[] args) {

        System.out.println("Welcome to Brandon's Branch");

        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));
        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));
        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));
        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));
        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));        FXMLLoader loader = new FXMLLoader(ReportMenu.this.getClass().getResource("/fxml/" +
                report.getClass().getCanonicalName().substring(18).replaceAll("Controller", "") + ".fxml"));









    }
}