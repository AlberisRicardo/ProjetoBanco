package Models;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import banco.ConnectionFactory;

public class Bus {
	private String empresa;
	private String placa;
	private String qtdPoltronas;

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getQtdPoltronas() {
		return qtdPoltronas;
	}

	public void setQtdPoltronas(String qtdPoltronas) {
		this.qtdPoltronas = qtdPoltronas;
	}

	public void addBus() throws ClassNotFoundException, SQLException {
		Connection con = null;
		try {
			con = new ConnectionFactory().getConnection();

			String sql = "insert into bus " + "(empresa,placa,qtdPoltronas) " + "values (?,?,?)";
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

			stmt.setString(1, this.empresa);
			stmt.setString(2, this.placa);
			stmt.setString(3, this.qtdPoltronas);
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Onibus cadastrado com sucesso");

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			con.close();
			System.out.println("conexão fechada.");
		}
	}

	public List<Bus> selectBus() throws ClassNotFoundException, SQLException {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Bus> lista = null;
		try {
			con = (Connection) new ConnectionFactory().getConnection();
			stmt = (PreparedStatement) con.prepareStatement("select * from Bus");

			lista = new ArrayList<Bus>();
			rs = (ResultSet) stmt.executeQuery();

			while (rs.next()) {
				Bus bus = new Bus();
				bus.setEmpresa(rs.getString("empresa"));
				bus.setPlaca(rs.getString("placa"));
				bus.setQtdPoltronas(rs.getString("qtdPoltronas"));
				lista.add(bus);
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

	public void editar(Bus bus) throws ClassNotFoundException, SQLException {

		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "update Bus set empresa=?, qtdPoltronas=? where placa=?";

		try {
			con = new ConnectionFactory().getConnection();
			stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, bus.getEmpresa());
			stmt.setString(2, bus.getQtdPoltronas());
			stmt.setString(3, bus.empresa);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
			;
		} finally {
			stmt.close();
			con.close();
		}
	}

	public void remove(Bus bus) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = new ConnectionFactory().getConnection();
			stmt = (PreparedStatement) con.prepareStatement("delete from Bus where placa=?");
			stmt.setString(1, bus.getPlaca());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			stmt.close();
			con.close();
		}
	}
	
	public List<Bus> selectBusPorEmpresa(String valor) throws ClassNotFoundException, SQLException {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Bus> lista = null;
		String str = "select * from Bus where empresa=" + valor;
		try {
			con = new ConnectionFactory().getConnection();
			stmt = (PreparedStatement) con.prepareStatement(str);

			lista = new ArrayList<Bus>();
			rs = (ResultSet) stmt.executeQuery();

			while (rs.next()) {
				Bus bus = new Bus();
				bus.setEmpresa(rs.getString("empresa"));
				bus.setPlaca(rs.getString("placa"));
				bus.setQtdPoltronas(rs.getString("qtdPoltronas"));
				lista.add(bus);
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
