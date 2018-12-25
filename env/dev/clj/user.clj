(ns user
  (:require [public-radio-services.config :refer [env]]
            [clojure.spec.alpha :as s]
            [expound.alpha :as expound]
            [mount.core :as mount]
            [public-radio-services.core :refer [start-app]]
            [public-radio-services.db.core]
            [conman.core :as conman]
            [luminus-migrations.core :as migrations]))

(alter-var-root #'s/*explain-out* (constantly expound/printer))

(defn start []
  (mount/start-without #'public-radio-services.core/repl-server))

(defn stop []
  (mount/stop-except #'public-radio-services.core/repl-server))

(defn restart []
  (stop)
  (start))

(defn restart-db []
  (mount/stop #'public-radio-services.db.core/*db*)
  (mount/start #'public-radio-services.db.core/*db*)
  (binding [*ns* 'public-radio-services.db.core]
    (conman/bind-connection public-radio-services.db.core/*db* "sql/queries.sql")))

(defn reset-db []
  (migrations/migrate ["reset"] (select-keys env [:database-url])))

(defn migrate []
  (migrations/migrate ["migrate"] (select-keys env [:database-url])))

(defn rollback []
  (migrations/migrate ["rollback"] (select-keys env [:database-url])))

(defn create-migration [name]
  (migrations/create name (select-keys env [:database-url])))


