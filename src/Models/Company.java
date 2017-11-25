package Models;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import banco.ConnectionFactory;

public class Company {

	private String cnpj;
	private String nome;
	private String qtdOnibus;
	private String qtdFuncionarios;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getQtdOnibus() {
		return qtdOnibus;
	}

	public void setQtdOnibus(String string) {
		qtdOnibus = string;
	}

	public String getQtdFuncionarios() {
		return qtdFuncionarios;
	}

	public void setQtdFuncionarios(String string) {
		qtdFuncionarios = string;
	}

	public void addCompany() throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = new ConnectionFactory().getConnection();

			String sql = "insert into company " + "(cnpj,nome,qtdOnibus,qtdFuncionarios) " + "values (?,?,?,?)";
			stmt = (PreparedStatement) con.prepareStatement(sql);

			stmt.setString(1, this.cnpj);
			stmt.setString(2, this.nome);
			stmt.setString(3, this.qtdOnibus);
			stmt.setString(4, this.qtdFuncionarios);
			stmt.execute();

			JOptionPane.showMessageDialog(null, "Empresa cadastrada com sucesso");

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			stmt.close();
			con.close();
			
		}
	}

	public List<Company> selectCompany() throws ClassNotFoundException, SQLException {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Company> lista = null;
		try {
			con = new ConnectionFactory().getConnection();
			stmt = (PreparedStatement) con.prepareStatement("select * from Company");

			lista = new ArrayList<Company>();
			rs = (ResultSet) stmt.executeQuery();

			while (rs.next()) {
				Company com = new Company();
				com.setCnpj(rs.getString("cnpj"));
				com.setNome(rs.getString("nome"));
				com.setQtdOnibus(rs.getString("qtdOnibus"));
				com.setQtdFuncionarios(rs.getString("qtdFuncionarios"));
				lista.add(com);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			rs.close();
			stmt.close();
			con.close();
		}
		return lista;

	}

	public void editar(Company com) throws ClassNotFoundException, SQLException {

		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "update company set nome=?, qtdOnibus=?, qtdFuncionarios=? where cnpj=?";

		try {
			con = new ConnectionFactory().getConnection();
			stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, com.getNome());
			stmt.setString(2,com.getQtdOnibus());
			stmt.setString(3,com.getQtdFuncionarios());
			stmt.setString(4,com.cnpj);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);;
		}finally {
			stmt.close();
			con.close();
		}
	}
	
	 public void remove(Company com) throws ClassNotFoundException, SQLException {
		 Connection con = null;
		 PreparedStatement stmt = null;
	     try {
	    	 con = new ConnectionFactory().getConnection();
	         stmt = (PreparedStatement) con
	                 .prepareStatement("delete from Company where cnpj=?");
	         stmt.setString(1, com.getCnpj());
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	        System.out.println(e);
	     }finally {
	    	 stmt.close();
	    	 con.close();
	     }
	 }
	 
	 public List<Company> selectCompanyPorCnpj(String valor) throws ClassNotFoundException, SQLException {

			Connection con = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<Company> lista = null;
			String str = "select * from Company where cnpj=" + valor;
			try {
				con = new ConnectionFactory().getConnection();
				stmt = (PreparedStatement) con.prepareStatement(str);

				lista = new ArrayList<Company>();
				rs = (ResultSet) stmt.executeQuery();

				while (rs.next()) {
					Company com = new Company();
					com.setCnpj(rs.getString("cnpj"));
					com.setNome(rs.getString("nome"));
					com.setQtdOnibus(rs.getString("qtdOnibus"));
					com.setQtdFuncionarios(rs.getString("qtdFuncionarios"));
					lista.add(com);
				}
			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				rs.close();
				stmt.close();
				con.close();
			}
			return lista;

		}

}
