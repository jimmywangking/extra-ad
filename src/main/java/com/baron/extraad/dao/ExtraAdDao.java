package com.baron.extraad.dao;

import com.baron.extraad.entity.ExtraAd;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 @package com.baron.extraad.entity
 @author Baron
 @create 2020-09-13-12:36 PM
 */
public interface ExtraAdDao extends JpaRepository<ExtraAd, Long> {
}
