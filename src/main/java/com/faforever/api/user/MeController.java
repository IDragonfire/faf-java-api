package com.faforever.api.user;

import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides the route {@code /me} which returns the currently logged in user's information.
 */
@RestController
public class MeController {

  @RequestMapping(method = RequestMethod.GET, value = "/me")
  @ApiOperation(value = "Returns the authentication object of the current user")
  @Secured({"ROLE_USER"})
  public Map<String, Object> me(Authentication authentication) {
    Map<String, Object> result = new HashMap<>();
    result.put("authentication", authentication);
    return result;
  }
}
