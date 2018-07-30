package com.raejz.sc.bus.movie;

import com.raejz.sc.config.API;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping(value = API.V1 + "/actors")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieController {
  private static final Logger logger = LoggerFactory.getLogger(MovieController.class);


}
