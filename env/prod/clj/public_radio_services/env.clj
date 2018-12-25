(ns public-radio-services.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[public-radio-services started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[public-radio-services has shut down successfully]=-"))
   :middleware identity})
