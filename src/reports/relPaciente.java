package reports;

import java.util.HashMap;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
import config.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.modPaciente;

/**
 * @data 18/06/2015
 * @author RUI PENTEADO
 */
public class relPaciente {

    private Conexao r_con = new Conexao();
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;

    public void relPaciente() throws Exception {

        this.sql = "SELECT * FROM pessoas";

        this.ps = r_con.openCon().prepareStatement(this.sql);

        this.rs = this.ps.executeQuery();

        JRResultSetDataSource jrs = new JRResultSetDataSource(this.rs);
        HashMap map = new HashMap();
        JasperPrint jp = JasperFillManager.fillReport("reports/relListPaciente.jasper", map, jrs);
        JasperViewer.viewReport(jp, false);

    }

    public void ficPaciente(modPaciente obj) throws Exception {
        
        this.sql = "Select * from pessoas HWERE id = ?";
        
        this.ps = r_con.openCon().prepareStatement(sql);
        
        ps.setInt(1, obj.getId());
        
        this.rs = ps.executeQuery();
        
        JRResultSetDataSource jrs = new JRResultSetDataSource(this.rs);
        HashMap map = new HashMap();
        JasperPrint jp = JasperFillManager.fillReport("reports/relFicPaciente.jasper", map, jrs);
        JasperViewer.viewReport(jp, false);
        
    }

}
