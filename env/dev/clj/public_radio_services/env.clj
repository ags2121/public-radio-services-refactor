(ns public-radio-services.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [public-radio-services.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[public-radio-services started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[public-radio-services has shut down successfully]=-"))
   :middleware wrap-dev})
