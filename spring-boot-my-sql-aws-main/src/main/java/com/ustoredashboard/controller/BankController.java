package com.ustoredashboard.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.ustoredashboard.entity.AccountDetails;
import com.ustoredashboard.entity.AccountRepository;
import com.univocity.parsers.common.record.Record;


@RestController
@RequestMapping(value="/upload", method=RequestMethod.POST)
public class BankController {
	
	@Autowired
	private AccountRepository service;
	
	@PostMapping
	public String uploadData(@RequestParam("file") MultipartFile file) throws Exception {
		List<AccountDetails> accountList = new ArrayList<>();
		InputStream inputStream = file.getInputStream();
		CsvParserSettings setting = new CsvParserSettings();
		setting.setHeaderExtractionEnabled(true);
		CsvParser parser = new CsvParser(setting);
		List<Record>parseAllRecords = parser.parseAllRecords(inputStream);
		parseAllRecords.forEach(record -> {
			AccountDetails account = new AccountDetails();
			account.setProductName(record.getString("product/ProductName"));
			account.setProductCode(record.getString("lineItem/ProductCode"));
			account.setLineItemType(record.getString("lineItem/LineItemType"));
			account.setBillType(record.getString("bill/BillType"));
			account.setBillingEntity(record.getString("bill/BillingEntity"));
			
			accountList.add(account);
		});
		service.saveAll(accountList);
		return "Upload feito com sucesso !!!";
	}
	
}
