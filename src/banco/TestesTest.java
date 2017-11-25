package banco;



import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;



import Models.Bus;
import Models.Company;

class TestesTest {

	
	@Test
	public void carregarPostgresqlDriver() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	} 
	@Test
	public void CarregarBanco() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		 DriverManager.getConnection(
		          "jdbc:mysql://localhost:3306/BusManagement", "root", "1234");
	}
	@Test
	public void inserirCompanyNoBanco() throws ClassNotFoundException, SQLException {
		Company com = new Company();
		com.setCnpj(JOptionPane.showInputDialog("cnpj"));
		com.setNome(JOptionPane.showInputDialog("nome"));
		com.setQtdOnibus(JOptionPane.showInputDialog("qtdOnibus"));
		com.setQtdFuncionarios(JOptionPane.showInputDialog("qtdFuncionarios"));
		com.addCompany();
	}
	
	@Test
	public void listarCompany() throws ClassNotFoundException, SQLException {
		Company com = new Company();
		List <Company> lista = new ArrayList<Company>();
		lista = com.selectCompany();
		System.out.println("______________________________");
		for( Company c: lista) {
			System.out.println("cnpj: " +  c.getCnpj());
			System.out.println("nome: " + c.getNome());
			System.out.println("qtdOnibus: " + c.getQtdOnibus());
			System.out.println("qtdFuncionarios: " + c.getQtdFuncionarios());
			System.out.println("______________________________");
		}
	}
	
	@Test
	public void editarCompany() throws ClassNotFoundException, SQLException {
		Company com = new Company();
		com.setCnpj("4321");
		com.setNome("novoNome");
		com.setQtdOnibus("20");
		com.setQtdFuncionarios("23");
		com.editar(com);
	}
	@Test
	public void removerCompany() throws ClassNotFoundException, SQLException {
		Company com = new Company();
		com.setCnpj("4321");
		com.setNome("novoNome");
		com.setQtdOnibus("20");
		com.setQtdFuncionarios("23");
		com.remove(com);
	}
	
	@Test
	public void listarCompanyPorCnpj() throws HeadlessException, ClassNotFoundException, SQLException {
		 Company com = new Company(); 
		  List <Company> lista = new ArrayList<Company>();
		  lista = com.selectCompanyPorCnpj("123");
		  System.out.println("______________________________"); 
		  for( Company c: lista)
		  { System.out.println("cnpj: " + c.getCnpj());
		   System.out.println("nome: " +
		  c.getNome()); 
		  System.out.println("qtdOnibus: " + c.getQtdOnibus());
		  System.out.println("qtdFuncionarios: " + c.getQtdFuncionarios());
		  System.out.println("______________________________");
		  }
	}
	
	@Test
	public void inserirBus() throws ClassNotFoundException, SQLException {
		Bus bus = new Bus();
		bus.setEmpresa(JOptionPane.showInputDialog("Empresa"));
		bus.setPlaca(JOptionPane.showInputDialog("Placa"));
		bus.setQtdPoltronas(JOptionPane.showInputDialog("QtdPoltronas"));
		bus.addBus();
	}
	@Test
	public void listarBus() throws ClassNotFoundException, SQLException {
		Bus bus = new Bus();
		List<Bus> lista = new ArrayList<Bus>();
		lista = bus.selectBus();
		System.out.println("______________________________");
		for( Bus b: lista) {
			System.out.println("Empresa: " +  b.getEmpresa());
			System.out.println("Placa: " + b.getPlaca());
			System.out.println("qtdPoltronas: " + b.getQtdPoltronas());
			System.out.println("______________________________");
		}
	}
	@Test
	public void editarBus() throws ClassNotFoundException, SQLException {
		Bus bus = new Bus();
		bus.setEmpresa("12345");
		bus.setPlaca("rrr 1234");
		bus.setQtdPoltronas(null);
		bus.editar(bus);
	}
	@Test
	public void removerBus() throws ClassNotFoundException, SQLException {
		Bus bus = new Bus();
		bus.setEmpresa("12345");
		bus.setPlaca("rrr 1234");
		bus.setQtdPoltronas(null);
		bus.remove(bus);
	}
	@Test
	public void listarBusPorEmpresa() throws HeadlessException, ClassNotFoundException, SQLException {
		  Bus bus = new Bus(); 
		  List<Bus> lista = new ArrayList<Bus>(); 
		  lista = bus.selectBusPorEmpresa(JOptionPane.showInputDialog("Cnpj da empresa do onibus")); 
		  System.out.println("______________________________"); 
		  for(Bus b: lista) {
			  System.out.println("Empresa: " + b.getEmpresa());
		  System.out.println("Placa: " + b.getPlaca());
		  System.out.println("qtdPoltronas: " + b.getQtdPoltronas());
		  System.out.println("______________________________"); }
	}
	
	
	
	

}
