package banco;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import Models.Bus;
import Models.Company;

public class Testes {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 
		  Bus bus = new Bus(); 
		  List<Bus> lista = new ArrayList<Bus>(); 
		  lista = bus.selectBusPorEmpresa("4321"); 
		  System.out.println("______________________________"); 
		  for(Bus b: lista) {
			  System.out.println("Empresa: " + b.getEmpresa());
		  System.out.println("Placa: " + b.getPlaca());
		  System.out.println("qtdPoltronas: " + b.getQtdPoltronas());
		  System.out.println("______________________________"); }
		
		/*
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
		*/
		
		/*
		Company com = new Company();
		com = com.selectCompanyPorCnpj(JOptionPane.showInputDialog("digite o cnpj da empresa"));

		System.out.println("______________________________");

		System.out.println("cnpj: " + com.getCnpj());
		System.out.println("nome: " + com.getNome());
		System.out.println("qtdOnibus: " + com.getQtdOnibus());
		System.out.println("qtdFuncionarios: " + com.getQtdFuncionarios());
		System.out.println("______________________________");
		*/
		/*
		 Company com = new Company(); 
		 com.setCnpj("123"); 
		 com.setNome("novoNome");
		 com.setQtdOnibus("20"); 
		 com.setQtdFuncionarios("23"); 
		 com.remove(com);
		 */
		/*
		  Bus bus = new Bus(); 
		  //bus.setEmpresa("12345"); 
		  bus.setPlaca("mvs 1234");
		 // bus.setQtdPoltronas(null);
		  bus.remove(bus);
		 */
		/*
		  Bus bus = new Bus(); 
		  List<Bus> lista = new ArrayList<Bus>(); 
		  lista =
		  bus.selectBus(); 
		  System.out.println("______________________________"); 
		  for(Bus b: lista) {
			  System.out.println("Empresa: " + b.getEmpresa());
		  System.out.println("Placa: " + b.getPlaca());
		  System.out.println("qtdPoltronas: " + b.getQtdPoltronas());
		  System.out.println("______________________________"); }
		 */

		/*
		  Company com = new Company(); 
		  List <Company> lista = new ArrayList<Company>();
		  lista = com.selectCompany();
		  System.out.println("______________________________"); 
		  for( Company c: lista)
		  { System.out.println("cnpj: " + c.getCnpj());
		   System.out.println("nome: " +
		  c.getNome()); 
		  System.out.println("qtdOnibus: " + c.getQtdOnibus());
		  System.out.println("qtdFuncionarios: " + c.getQtdFuncionarios());
		  System.out.println("______________________________");
		   }
		*/

		/*
		  Bus bus = new Bus();
		  bus.setEmpresa(JOptionPane.showInputDialog("Empresa"));
		  bus.setPlaca(JOptionPane.showInputDialog("Placa"));
		  bus.setQtdPoltronas(JOptionPane.showInputDialog("QtdPoltronas"));
		  bus.addBus();
		 */
		/*
		  Company com = new Company();
		  com.setCnpj(JOptionPane.showInputDialog("cnpj"));
		 com.setNome(JOptionPane.showInputDialog("nome"));
		  com.setQtdOnibus(JOptionPane.showInputDialog("qtdOnibus"));
		  com.setQtdFuncionarios(JOptionPane.showInputDialog("qtdFuncionarios"));
		  com.addCompany();
	  	*/
	}

}
