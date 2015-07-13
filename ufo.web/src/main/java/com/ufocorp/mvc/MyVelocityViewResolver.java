package com.ufocorp.mvc;

import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

public class MyVelocityViewResolver extends VelocityViewResolver{
	/**
	 * Requires {@link VelocityView}.
	 */
	@Override
	protected Class<VelocityView> requiredViewClass() {
		return VelocityView.class;
	}
}
