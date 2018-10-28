package com.raejz.sc.bus.movie;

import com.raejz.sc.config.API;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping(value = API.V1 + "/actors")
public class MovieController {
  private static final Logger logger = LoggerFactory.getLogger(MovieController.class);


}
