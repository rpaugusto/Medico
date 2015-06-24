package reports;

import java.util.HashMap;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
import config.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.modFuncionario;

/**
 * @data 24/06/2015
 * @author RUI PENTEADO
 */
public class relFuncionario {
    
    private final Conexao r_con = new Conexao();
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public void ficFuncionario(modFuncionario obj) throws Exception{
        
        this.sql =  "SELECT * FROM funcionarios WHERE id = ?";
        
        this.ps = r_con.openCon().prepareStatement(sql);
        
        ps.setInt(1, obj.getId());
        
        this.rs = ps.executeQuery();
        
        JRResultSetDataSource jrs = new JRResultSetDataSource(this.rs);
        HashMap map = new HashMap();
        JasperPrint jp = JasperFillManager.fillReport("reports/relFicFuncionario.jasper", map, jrs);
        JasperViewer.viewReport(jp, false);
    }
    
}
