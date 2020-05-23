package com.capgemini.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entities.Wallet;



@Repository
public interface WalletDAO extends JpaRepository<Wallet, Integer> {

}