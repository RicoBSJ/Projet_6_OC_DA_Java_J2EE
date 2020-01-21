package com.aubrun.eric.projet6.business.mapper;

import com.aubrun.eric.projet6.business.dto.SiteDto;
import com.aubrun.eric.projet6.model.bean.Site;

public class SiteDtoMapper {

	static public SiteDto toDto(Site site) {

		SiteDto dto = new SiteDto();
		dto.setNomSite(site.getNomSite());
		return dto;

	}
}