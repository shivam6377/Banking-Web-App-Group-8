package com.atcs.finalproject.grp8.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atcs.finalproject.grp8.Entity.AccHolder;
import com.atcs.finalproject.grp8.Entity.CurrentAcc;
import com.atcs.finalproject.grp8.Entity.SavingAcc;
import com.atcs.finalproject.grp8.Repo.savingRepo;
import com.atcs.finalproject.grp8.ServiceImp.AccHolderimpl;
import com.atcs.finalproject.grp8.ServiceImp.SavingAccserimpl;

@RestController
@RequestMapping("/savingacc")

public class SavingAccController {
	@Autowired
	savingRepo savingRepoAuto;
	@Autowired
	AccHolderimpl AccHolderimplAuto;
	@Autowired
	SavingAccserimpl SavingAccserimplAuto;
	
	
	@GetMapping("/")
	public List<SavingAcc> getdata(){
		return SavingAccserimplAuto.getdata() ;
	}
	@GetMapping("{id}")
	public SavingAcc getdatabyid(@PathVariable("id")long Acc_noS) {
		return SavingAccserimplAuto.getdatabyid(Acc_noS);
	}
	@GetMapping("/mapeddata")
	public List<AccHolder> getdatabyid() {
		return AccHolderimplAuto.getdata();
	}
	@PostMapping("/")
	public List<SavingAcc> postdata(@RequestBody SavingAcc s){
		return SavingAccserimplAuto.postdata(s);
	}
	@PutMapping("/")
	public List<SavingAcc> putdata(@RequestBody SavingAcc s){
		return SavingAccserimplAuto.putdata(s); 
	}
	@PutMapping("/deposit/{balance}")
	public double putdatabypin( @PathVariable("balance")double balance,@RequestBody SavingAcc s ){
		
		return SavingAccserimplAuto.putdatabypin(balance,s); 
	}
	@PutMapping("/withdraw/{balance}")
	public double putdatabypinwithdraw( @PathVariable("balance")double balance,@RequestBody SavingAcc s ){
		
		return SavingAccserimplAuto.putdatabypinwithdraw(balance,s); 
	}
	@DeleteMapping("/{id}")
	public List<SavingAcc> deletedata(@PathVariable("id") long Acc_noS){
		return SavingAccserimplAuto.deletedata(Acc_noS);
	}

}
