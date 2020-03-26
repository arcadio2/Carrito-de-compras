package Administrador;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.servlet.ServletException;

public class Metodos {

    public Connection conecta() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver).newInstance();
        Connection con = null;
        Statement set = null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/carrito?user=root&password=n0m3l0";
        con = DriverManager.getConnection(url);
        return con;
    }
    private String ObtenFechaDia() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Statement set = null;
        ResultSet rs = null;
        set = conecta().createStatement();
        Calendar fecha = new GregorianCalendar();
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String nombre_mes = null;
        boolean primer_dia = false;
        if ((mes + 1) < 10) {
            nombre_mes = "0" + (mes + 1);
        } else {
            nombre_mes = Integer.toString(mes + 1);
        }
        if (dia == 1) {
            primer_dia = true;
        }
        if (primer_dia) {
            set.execute("delete from ventasgrafico;");
        }
        String Actual = dia + "-" + nombre_mes;
        return Actual;
    }
    private int id() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Statement set = null;
        ResultSet rs = null;
        set = conecta().createStatement();
        Calendar fecha = new GregorianCalendar();
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        return dia;
    }
    private void actualiza(double cantidad) throws SQLException, ServletException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Statement set = null;
        ResultSet rs = null;
        set = conecta().createStatement();
        String actualizar = "call InsertaDatoGrafico("+id()+",'"+ObtenFechaDia()+"',"+cantidad+");";
        set.execute(actualizar);
    }
    public void aumentaventa(double ganancia) throws ClassNotFoundException, ServletException, InstantiationException, SQLException, IllegalAccessException{
        Statement set = null;
        ResultSet rs = null;
        set = conecta().createStatement();
        rs = set.executeQuery("select * from ventasgrafico;");
        rs.last();
        double ventas = 0;
        boolean misma_fecha = false;
        if (rs.getString(2).equals(ObtenFechaDia())) {
            misma_fecha = true;
        }
        if (misma_fecha) {
            ventas = rs.getInt(3);
            ventas = ventas + ganancia;
        }else{
            ventas = 0;
            ventas = ventas + ganancia;
        }
        actualiza(ventas);
    }
    
    /*public List<String> obtenpanes() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        List <String> obten = new ArrayList<>(); 
        Statement set = null;
        ResultSet rs = null;
        set = conecta().createStatement();
        rs = set.executeQuery("select * from subproductos;");
        int n = 0;
        while (rs.next()){
            n++;
        }
        int a = 0, b= 0, c = 0, d = 0, e = 0, temporal = 0;
        for (int i = 0; i < n; i++) {
            rs = set.executeQuery("select * from detalleventa where det_codigo="+n+";");
            while (rs.next()){
                temporal = temporal + rs.getInt(5);
            }
            if (temporal > a) {
                a = temporal;
            }
        }
        
        
       return obten; 
    }*/
    
    
    
}
