package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import model.Post;

public class PostDAOImpl implements PostDAO {
	
	@Autowired
	private springConnection scon;
	
	@Override
	public int insert(Post post) {
		int res = -1;
		try {
			PreparedStatement pst = ((Connection) scon).prepareStatement("insert into posts (title,body) values(?,?)");
			pst.setString(1, post.getTitle());
			pst.setString(2, post.getBody());
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(Post post) {
		int res = -1;
		try {
			PreparedStatement pst = ((Connection) scon).prepareStatement("update posts set title = ? , body = ? where id = ?");
			pst.setString(1, post.getTitle());
			pst.setString(2, post.getBody());
			pst.setInt(3, post.getId());
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int id) {
		int res = -1;
		try {
			PreparedStatement pst = ((Connection) scon).prepareStatement("delete from posts where id = ?");
			pst.setInt(1, id);
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Post> view() {

		ArrayList<Post> list = new ArrayList<>();
		try {
			Statement st = ((Connection) scon).createStatement();
			ResultSet rs = st.executeQuery("select * from posts");
			while (rs.next()) {
				list.add(new Post(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Post view(int id) {
		Post post = new Post();
		try {
			PreparedStatement pst = ((Connection) scon).prepareStatement("select * from posts where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				post = new Post(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return post;
	}

	public springConnection getScon() {
		return scon;
	}

	public void setScon(springConnection scon) {
		this.scon = scon;
	}

}
