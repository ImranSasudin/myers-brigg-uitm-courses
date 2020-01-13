package model;

public class adminBean {
		
		private String adminIc;
		private String adminEmail;
		private String adminName;
		private String adminPhone;
		private String adminPassword;
		public boolean valid;
		
		public String getadminIc() {
			return adminIc;
		}
		public void setadminIc(String adminIc) {
			this.adminIc = adminIc;
		}
		public String getadminName() {
			return adminName;
		}
		public void setadminName(String adminName) {
			this.adminName = adminName;
		}
		public String getadminEmail() {
			return adminEmail;
		}
		public void setadminEmail(String adminEmail) {
			this.adminEmail = adminEmail;
		}
		public String getadminPhone() {
			return adminPhone;
		}
		public void setadminPhone(String adminPhone) {
			this.adminPhone = adminPhone;
		}
		
		public String getadminPassword() {
			return adminPassword;
		}
		public void setadminPassword(String adminPassword) {
			this.adminPassword = adminPassword;
		}
		/*
		public int getManager_id() {
			return manager_id;
		}
		public void setManager_id(int manager_id) {
			this.manager_id = manager_id;
		} */
		public boolean isValid() {
			return valid;
		}
		public void setValid(boolean valid) {
			this.valid = valid;
		}
		
		
}
