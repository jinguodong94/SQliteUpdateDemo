package com.example.dbupdatedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
	public static final int VERSION = 4;

	public DbHelper(Context context) {
		super(context, "db_demo.db", null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table test(name text,age int);";
		db.execSQL(sql);
	}

	// 当VERSION号发生改变的时候就会调用此方法
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// // 循环更新表
		for (int x = oldVersion; x < newVersion; x++) {
			switch (x) {
			case 1:
				System.out.println("update..........1.........");
				String sql0 = "ALTER TABLE test ADD COLUMN gender VARCHAR";
				db.execSQL(sql0);
				break;
			case 2:
				System.out.println("update..........2.........");
				String sql1 = "ALTER TABLE test ADD COLUMN address VARCHAR";
				db.execSQL(sql1);
				break;
			case 3:
				System.out.println("update........3...........");
				String sql2 = "ALTER TABLE test ADD COLUMN tel VARCHAR";
				db.execSQL(sql2);
				break;
			default:
				break;
			}
		}
	}
}