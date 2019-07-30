-- ここから始まって行末までコメントアウト --の後に必ず半角スペース
/*から　・・・・・　まで*/

set names utf8; -- MySQL の文字セット名はハイフンを含まない
set foreign_key_checks = 0; -- 外部キー制約のあるテーブルが操作できるようになる

drop database if exists ecsite2; -- 同名dbがあるば削除
create database if not exists ecsite2; -- 同名dbがなければ作成
use ecsite2;

-- テーブル作成(ユーザー情報
drop table if exists login_user_transaction;
create table login_user_transaction(
	id int not null primary key auto_increment, 	-- 空白NG 主キー(インデックス用 重複NG) 自動連番
	login_id varchar(16) unique, 	-- (重複NG
	login_pass varchar(16),
	user_name varchar(50),
	insert_date datetime, -- datetime
	update_date datetime
	);

-- テーブル作成(商品情報
drop table if exists item_info_transaction;
create table item_info_transaction(
	id int not null primary key auto_increment,
	item_name varchar(30),
	item_price int,
	item_stock int,
	insert_date datetime,
	update_date datetime
	);

-- テーブル作成(購入商品情報
drop table if exists user_buy_item_transaction;
create table user_buy_item_transaction(
	id int not null primary key auto_increment,
	item_transaction_id int,
	total_price int,
	total_count int,
	user_master_id varchar(16),
	pay varchar(30),
	insert_date datetime,
	delete_date datetime
	);

-- 作成したテーブルに情報を格納する
	INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("ノートbook",100,50);

	INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUE("a","a","a");