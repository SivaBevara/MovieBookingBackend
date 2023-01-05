//package com.cg.service;
//
//import javax.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.cg.entity.Admin;
//import com.cg.exception.AdminNotFoundException;
//import com.cg.repository.AdminRepository;
//
//@Service
//public class AdminServiceImpl implements AdminService {
//	@Autowired
//	private AdminRepository adminRepository;
//
//	@Transactional
//	@Override
//	public Admin addAdmin(Admin admin) {
//
//		return adminRepository.save(admin);
//	}
//
//	@Override
//	public Admin checkLogin(String userName, String password) {
//
//		Admin admin = adminRepository.checkLogin(userName, password);
//		return admin;
//
//	}
//
//	@Override
//	public Admin getAdmin(int adminId) throws AdminNotFoundException {
//
//		Admin a = adminRepository.getById(adminId);
//		if (a == null) {
//			throw new AdminNotFoundException("admin not found");
//		}
//		return a;
//	}
//
//}