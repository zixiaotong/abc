package com.abc.abc.model.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program:abc
 * @author:shanglei
 * @createtime:2019-12-10 18:14
 **/
@Component
public class Random {
    @Value("${random.v}")
	private String v;
    @Value("${random.i}")
	private String i;
    @Value("${random.l}")
	private String l;
    @Value("${random.teni}")
	private String teni;
    @Value("${random.two}")
	private String twoi;

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public String getI() {
		return i;
	}

	public void setI(String i) {
		this.i = i;
	}

	public String getL() {
		return l;
	}

	public void setL(String l) {
		this.l = l;
	}

	public String getTeni() {
		return teni;
	}

	public void setTeni(String teni) {
		this.teni = teni;
	}

	public String getTwoi() {
		return twoi;
	}

	public void setTwoi(String twoi) {
		this.twoi = twoi;
	}
}
