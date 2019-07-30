package com.internousdev.ecsite2.util;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

//UserCreateCompleteDAOから呼び出される。
	public String getDate(){
		Date date = new Date();

/* SimpleDateFormat sdf = new SimpleDateFormat(“フォーマットパターン”);
 * と、日付のフォーマットを設定するには、
 * インスタンスの引数に日付フォーマットを指定する必要がある。*/
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

// SimpleDateFormatクラスの日付パターンを返すformatメソッド
		return simpleDateFormat.format(date);
	}
}
