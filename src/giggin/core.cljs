(ns giggin.core
  (:require
    [reagent.core :as r]))

(defn app
  []
  [:div {:class "container"}])

(defn ^:export main
  []
  (r/render
    [app]
    (.getElementById js/document "app")))

