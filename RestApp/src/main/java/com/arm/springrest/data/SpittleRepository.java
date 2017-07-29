package com.arm.springrest.data;
import java.util.List;
import org.springframework.stereotype.Component;

import com.arm.springrest.spittr.Spittle;


public interface SpittleRepository {

	List<Spittle> findSpittle(long max, int count);
	Spittle findOne (long spittleId);
}
