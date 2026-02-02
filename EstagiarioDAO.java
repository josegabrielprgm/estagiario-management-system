package br.com.jose.sistemaestagiario.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.jose.sistemaestagiario.domain.Estagiario;

public class EstagiarioDAO {

	public void salvar(Estagiario e) {
		String sql = "INSERT INTO estagiario (cpf, nome, tel, idade) VALUES (?, ?, ?, ? )";

		try {
			Connection conn = Conexao.conectar();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, e.getCpf());
			ps.setString(2, e.getNome());
			ps.setInt(3, e.getTel());
			ps.setInt(4, e.getIdade());

			ps.executeUpdate();
			System.out.println("Estagiario salvo no banco!");

		} catch (SQLException ex) {

			System.out.println("Erro ao salvar: " + ex.getMessage());

		}
	}

	public List<Estagiario> listar() {

		List<Estagiario> lista = new ArrayList<>();
		String sql = "SELECT * FROM estagiario";

		try {
		
				Connection conn = Conexao.conectar();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Estagiario e = new Estagiario();
				e.setCpf(rs.getString("cpf"));
				e.setNome(rs.getString("nome"));
				e.setTel(rs.getInt("tel"));
				e.setIdade(rs.getInt("idade"));
				lista.add(e);

			}
		} catch (SQLException ex) {

			System.out.println("Erro ao listar: " + ex.getMessage());

		}

		return lista;
	}

	public void apagar(String cpf) {
		String sql = "DELETE FROM estagiario WHERE cpf = ?";

		try {
			Connection conn = Conexao.conectar();
			PreparedStatement ps = conn.prepareStatement(sql)
				
			ps.setString(1, cpf);
			ps.executeUpdate();
			System.out.println("Estagiario apagado do banco!");

		} catch (SQLException ex) {
			System.out.println("Erro ao editar: " + ex.getMessage());

		}
	}

	public void editar(Estagiario e) {

		String sql = "UPDATE estagiario SET nome = ?, tel = ?, idade = ? WHERE cpf = ?";

		try {
			Connection conn = Conexao.conectar();
			PreparedStatement ps = conn.prepareStatement(sql)
				
			ps.setString(1, e.getNome());
			ps.setInt(2, e.getTel());
			ps.setInt(3, e.getIdade());
			ps.setString(4, e.getCpf());

			int linhas = ps.executeUpdate();

			if (linhas > 0) {
				System.out.println("Estagiario editado com sucesso!");

			} else {
				System.out.println("CPF não encotrado!");
			}

		} catch (SQLException ex) {
			System.out.println("Erro ao editar: " + ex.getMessage());
		}
	}

}


