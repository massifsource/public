package com.massifsource.sync.db.h2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "directory")
public class Directory {

		@Id()
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(name="name", nullable=false)
		private String name;
		
		public Directory (String name) {
			this.name = name;
		}
		
		public Directory() {
		}
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
}
