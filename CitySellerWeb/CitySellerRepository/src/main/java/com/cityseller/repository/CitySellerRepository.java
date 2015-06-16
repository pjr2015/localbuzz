package com.cityseller.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;

import com.cityseller.repository.configuration.CitySellerRepositoryConfiguration;

/**
 * Hello world!
 *
 */
@Import(CitySellerRepositoryConfiguration.class)
public class CitySellerRepository 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(CitySellerRepository.class, args);
        System.out.println( "Hello World!" );
    }
}
