(ns rum-bug-class.browser
  (:require [rum.core :as rum]
            [rum-bug-class.components :as ui]))

(rum/mount (ui/simple)
           (.getElementById js/document "app"))
