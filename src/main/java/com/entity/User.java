package com.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Detail_table")
public class User {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	private String CCPortalUrl;
	private String Database;
	private String SDPUrl;
	private String ServerDetails;
	private String aggregrator;
	private String amount;
	private String callBackUrl;
	private String client;
	private String developer;
	private String frontEndUrl;
	private String localLocation;
	private String schedulersBackendUrl;
	private String service;
	private String serviceLaunchDate;
	private String serviceManager;
	private String field1;
	private String field2;
	private String field3;
	private String field4;
	private String field5;
	private String field6;
	private String field7;
	private String field8;
	private String field9;
	private String field10;
		
}
