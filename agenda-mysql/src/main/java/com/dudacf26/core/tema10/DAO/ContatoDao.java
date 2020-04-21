package com.dudacf26.core.tema10.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dudacf26.core.tema10.DOMAIN.Contato;

public class ContatoDao {

	private Contato contato = new Contato();

	public boolean adicionarCont(Contato contato) {
		try (Connection con = ConexaoBanco.abrir();
				PreparedStatement stmt = con
						.prepareStatement("INSERT INTO contato (nome,telefone,email) VALUES(?,?,?)")) {
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getTelefone());
			stmt.setString(3, contato.getEmail());
			stmt.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Contato> listarContatos() {
		List<Contato> listaDeContatos = new ArrayList<Contato>();
		try (Connection con = ConexaoBanco.abrir();
				PreparedStatement stmt = con.prepareStatement("SELECT * FROM contato")) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				contato = instanciaContato(rs);
				listaDeContatos.add(contato);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return listaDeContatos;

	}

	public Contato buscarContatoPorNome(String nome) {
		List<Contato> listaDeContatos = new ArrayList<Contato>();
		try (Connection con = ConexaoBanco.abrir();
				PreparedStatement stmt = con.prepareStatement("SELECT * FROM contato WHERE nome = '" + nome + "'")) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				contato = instanciaContato(rs);
				listaDeContatos.add(contato);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return listaDeContatos;
	}

	public Contato buscarContatoPorId(int id) {
		try (Connection con = ConexaoBanco.abrir();
				PreparedStatement stmt = con.prepareStatement("SELECT * FROM contato WHERE id = '" + id + "'")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				contato = instanciaContato(rs);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return Contato;
	}

	public boolean removerCont(int id) {
		try (Connection con = ConexaoBanco.abrir();
				PreparedStatement stmt = con.prepareStatement("DELETE FROM contato where id = ?")) {
			stmt.setInt(1, id);
			stmt.execute();
			System.out.println("Contato Removido");
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Contato> ordenaContatos(String tipo) {
		List<Contato> contatos = new ArrayList<Contato>();
		try (Connection connection = ConexaoBanco.abrir()) {
			String sql = "select * from contato order by " + tipo + ";";
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet resultset = pstm.executeQuery();
			while (resultset.next()) {
				contatos.add(new Contato(resultset.getString("nome"), resultset.getString("email"),
						resultset.getString("telefone")));
			}
			resultset.close();
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contatos;
	}

	private Contato instaciaContato(ResultSet result) throws SQLException {
		Contato contato = new Contato();
		contato.setId(result.getInt("id"));
		contato.setNome(result.getString("nome"));
		contato.setEmail(result.getString("email"));
		contato.setTelefone(result.getInt("telefone"));
		return contato;
	}
}
