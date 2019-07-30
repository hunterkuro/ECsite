	package com.internousdev.ecsite2.util;
// importすることでメソッドの参照先を省略できる
	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 実行メソッド
	public class DBConnector {
	// 接続に必要な情報の設定
		private static String driverName = "com.mysql.jdbc.Driver";
		private static String url = "jdbc:mysql://localhost/ecsite2";
		private static String user = "root";
		private static String password = "mysql";

	// 接続メソッド
		public Connection getConnection(){
			Connection con = null;

			try{
			// ドライバクラスを指定してDB接続
				Class.forName(driverName);
				con = (Connection) DriverManager.getConnection(url,user,password); //getConnectionメソッドで接続。戻り値をconに格納。
		// 例外の記述。
			}catch(ClassNotFoundException e){ // 存在しないクラスを指定した場合→これdriverName="com.mysql.jdbc.Driver"
				e.printStackTrace();
			}catch(SQLException e){ // SQL実行時のエラー。【テーブル名が違う】【重複をINSERTした】など。具体的なエラー内容はデータベースのエラーコードで確認しないといけない
				e.printStackTrace();
			}
		// MySQLに接続できたか、情報を渡す。
			return con;
		}
	}
