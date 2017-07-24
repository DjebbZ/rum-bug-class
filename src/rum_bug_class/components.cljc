(ns rum-bug-class.components
  (:require [rum.core :as rum]))

(rum/defc simple []
  [:h1 {:class (when false "no-class")} "Hello world"])
