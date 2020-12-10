package com.cg.validation;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.IntrusionException;
import org.owasp.esapi.errors.ValidationException;
import org.springframework.stereotype.Component;

import com.cg.exception.InvalidInputException;
import com.cg.vo.EnquiryTypeVo;
import com.cg.vo.EnquiryVo;
import com.cg.vo.MechanicsVo;
import com.cg.vo.RoleVo;
import com.cg.vo.ServiceTypeVo;
import com.cg.vo.ServiceVo;
import com.cg.vo.UserVo;
import com.cg.vo.VehicleTypeVo;

@Component
public class ValidCheck {

	public boolean serviceCheck(ServiceVo vo) throws IntrusionException, ValidationException, InvalidInputException {
		
		String brand=vo.getVehicleBrand();
		String regNo=vo.getVehicleRegno();
		boolean result=false;
		boolean isValid = ESAPI.validator().isValidInput("addRegNo", regNo, "CreditCard", 20, false);
		String pat=ESAPI.validator().getValidInput("Validationofinput",brand,"SafeString",30, true) ;
		if(isValid) {
			if(pat.length()<=20) {
				result=true;
			}
			else {
				throw new InvalidInputException("The given brand name is must within 20 characters!!");
			}
		}
		else {
			throw new InvalidInputException("The given Registration number is not valid!!");
		}
		
		return result;
	}
	
	public boolean serviceTypeCheck(ServiceTypeVo vo)throws InvalidInputException, IntrusionException, ValidationException {
		boolean result = false;
		String serviceTypeName = vo.getServiceTypeName();
		String pat=ESAPI.validator().getValidInput("Validationofinput",serviceTypeName,"SafeString",30, true) ;
		if(pat.length() <= 15) {
			 result = true;
		}
		else {
			throw new InvalidInputException("Enter proper servicetypename");
		}
		return result;
	}
	
	public boolean mechanicCheck(MechanicsVo vo) throws IntrusionException, ValidationException, InvalidInputException {
		boolean val=false;
		String mobNum=vo.getMobileNumber();
		String name=vo.getFirstName();
		String email=vo.getEmail();
		String regexPhone = "^[0-9]{10}$";
		boolean isValid = ESAPI.validator().isValidInput("addEmail", email, "Email", 20, false);
		if(!isValid) {
			throw new InvalidInputException("The given EmailId is not valid");
		}
		if(isValid) {
			if(mobNum.matches(regexPhone)) {
				String pat=ESAPI.validator().getValidInput("Validationofinput",name,"SafeString",30, true) ;
				if(pat.length()<=15) {
					//boolean isPass = ESAPI.validator().isValidInput("addPassword", pass, "Password", 20, true);
					val=true;
				}
				else {
					throw new InvalidInputException("The given Name is not valid make sure its lesser than 15");
				}
			}
			else {
				throw new InvalidInputException("The given MobileNumber is not valid");
			}
		}
		return val;
	}
	
	public boolean roleCheck(RoleVo vo)throws InvalidInputException, IntrusionException, ValidationException {
		boolean result = false;
		String roleName = vo.getRoleName();
		String pat=ESAPI.validator().getValidInput("Validationofinput",roleName,"SafeString",30, true) ;
		if(pat.length() <= 20) {
			 result = true;
		}
		else {
			throw new InvalidInputException("Enter proper rolename");
		}
		return result;
	}
	
	public boolean enquiryTypeCheck(EnquiryTypeVo vo) throws IntrusionException, ValidationException, InvalidInputException {
		boolean value = false;
		String name=vo.getEnquiryTypeName();
		
				String pat=ESAPI.validator().getValidInput("Validationofinput",name,"SafeString",30, true) ;
				if(pat.length()<=15) {
					value = true;
				}
				else {
					throw new InvalidInputException("The given Name is not valid make sure its lesser than 30");
				}
				return value;
	}
	
	public boolean enquiryCheck(EnquiryVo enqVo) throws IntrusionException, ValidationException, InvalidInputException {
		boolean result=false;
		
		String enquiryDescription=enqVo.getDescription();
		String pat=ESAPI.validator().getValidInput("Validationofinput",enquiryDescription,"SafeString",30, true) ;
		if(pat.length()<=25) {
			result=true;
		}
		else {
			throw new InvalidInputException("The given Enquiry Description is must within 200 characters!!");
		}
		
		return result;
	}
	
	public boolean vehicletypeCheck(VehicleTypeVo vo)throws InvalidInputException, IntrusionException, ValidationException {
		boolean result = false;
		String vehicletypeName = vo.getVehicleTypeName();
		String pat=ESAPI.validator().getValidInput("Validationofinput",vehicletypeName,"SafeString",30, true) ;
		if(pat.length() <= 20) {
			 result = true;
		}
		else {
			throw new InvalidInputException("length had been exceded above 20 characters");
		}
		return result;
	}
	
	public boolean userCheck(UserVo vo) throws IntrusionException, ValidationException, InvalidInputException {
		boolean val=false;
		String regexPhone = "^[0-9]{10}$";
	    String regexPass = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		String mobNum=vo.getMobileNumber();
		String email=vo.getEmail();
		String name=vo.getFirstName();
		String pass=vo.getPassword();
		boolean isValid = ESAPI.validator().isValidInput("addEmail", email, "Email", 20, false);
		String pat=ESAPI.validator().getValidInput("Validationofinput",name,"SafeString",30, true) ;
		boolean isPass = ESAPI.validator().isValidInput("addPassword", pass, "Password", 20, true);
		if(isValid) {
			if(mobNum.matches(regexPhone)) {
				if(pat.length()<=15) {
					if(pass.matches(regexPass)) {
						val=true;
					}
					else {
						throw new InvalidInputException("The given password doesn't meet excpected level");
					}
				}
				else {
					throw new InvalidInputException("The given Name is not valid make sure its lesser than 15");
				}
			}
			else {
				throw new InvalidInputException("The given MobileNumber is not valid");
			}
		}
		else {
			  throw new InvalidInputException("The given EmailId is not valid");
		}
		return val;
	}
}
