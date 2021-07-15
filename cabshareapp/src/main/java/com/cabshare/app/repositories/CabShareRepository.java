package com.cabshare.app.repositories;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cabshare.app.model.request.CabShareRequestModel;

@Repository
public interface CabShareRepository 
		extends JpaRepository<CabShareRequestModel,Long> {
  
	
	//implementation of - a sql query to filter by start-time, which should -
	//...be between start-time and end-time of request.
   @Query("select res from CabShareRequestModel res where "
   		+ "res.geoHashCode=:geocode and res.timeStart between :stime and :etime "
		   
   	//	+ "res.timeStart between :req.timeStart and :req.timeEnd"
   		)
	 List<CabShareRequestModel> findAllByGeoHashCodeAndTime(@Param("geocode") String geoHashCode,@Param("stime") LocalDateTime stime, @Param("etime") LocalDateTime etime);

	//List<CabShareRequestModel> findAllByGeoHashCodeAndTime(@Param("geocode") String geoHashCode, @Param("req") CabShareRequestModel req);

   
}
