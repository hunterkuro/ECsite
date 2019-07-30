<%-- JSPでのコメントアウト --%>
<%-- JSPページ内はHTML文を直接入力できるので<!-- -->でのコメントアウトもできるが、
	コメントが記述されたHTML文となってしまう。 --%>
<%-- 自動生成文 --%>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- strutsを使う宣言 s: が使用できる --%>
	<%@ taglib prefix = "s" uri="/struts-tags"%>

<%-- 自動生成文 --%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<html>
	<head>
<%-- meta要素のプラグマ指示子: 実行命令を指示するもの--%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagetoolbar" content="text/css"/>	<%--文書内の画像にマウスポインタを合わせると、小さなツールバーが出てくるもの --%>
	<meta name="description" content=""/>	<%--SEO対策。検索結果のタイトル下の説明文章 --%>
	<meta name="keywords" content=""/>	<%--クローラーに伝えるページのキーワード。検索制度が上がった今、指定する意味がない --%>
	<title>Home画面</title>

<%-- cssの読み込み --%>
	<link rel="stylesheet" type="text/css" href="./css/style.css">


	</head>
	<body>
		<div id="header">	<%-- --%>
			<div id="pr">
			</div>
		</div>
		<div id ="main">
			<div id="top">
				<p>Home</p>
			</div>
			<div id="text-center">

<%-- formタグ：送信先となるaction属性にデータを渡すmethod(postかget)を指定できる --%>
				<s:form action="HomeAction">
					<s:submit value="商品購入"/>
				</s:form>

<%--ifタグのtestは、プロパティ名。testプロパティがtrueの場合、ifタグに囲まれている部分を表示。(falseの場合はelseタグで囲まれている部分を表示。)
	 testは※オブジェクトのプロパティにアクセスする場合のみ#が必要--%>
				<s:if test="#session.login_user_id!= null">
					<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a></p>
				</s:if>
			</div>
		</div>
		<div id="footer">
			<div id="pr">
			</div>
		</div>
	</body>
	</html>