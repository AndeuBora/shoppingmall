<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="mngr.enc.PassCrypt"%>


<%
	System.out.println("passCrypt 실행");
	PassCrypt dbPro = PassCrypt.getInstance();
	System.out.println("passCrypt 메소드 실행");
	dbPro.cryptProcess();
	out.println("암호화 성공! 꼭 한번만 수행");
%>