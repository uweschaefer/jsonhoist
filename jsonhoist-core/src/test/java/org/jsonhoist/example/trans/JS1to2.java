package org.jsonhoist.example.trans;

import org.jsonhoist.trans.JSJsonTransformation;

public class JS1to2 extends JSJsonTransformation {

	public JS1to2() {
		super(JS1to2.class.getResource("/v1_to_v2.js"));
	}

}