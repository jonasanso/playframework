/*
 * Copyright (C) 2009-2016 Lightbend Inc. <https://www.lightbend.com>
 */
package javaguide.logging;

//#logging-pattern-filter
import java.lang.reflect.Method;

import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.Logger.ALogger;
import play.mvc.Action;
import play.mvc.Http.Request;

public class Global extends GlobalSettings {

  private final ALogger accessLogger = Logger.of("access");

  @Override
  @SuppressWarnings("rawtypes")
  public Action onRequest(Request request, Method method) {
    accessLogger.info("method={} uri={} remote-address={}", request.method(), request.uri(), request.remoteAddress());

    return super.onRequest(request, method);
  }

  @Override
  public void onStart(Application app) {
    Logger.info("Application has started");
  }

  @Override
  public void onStop(Application app) {
    Logger.info("Application has stopped");
  }

}
//#logging-pattern-filter
