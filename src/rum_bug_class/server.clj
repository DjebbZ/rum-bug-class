(ns rum-bug-class.server
  (:require [rum.core :as rum]
            [rum-bug-class.components :as ui]))

(def page
  (str
    "<!DOCTYPE html>
    <html>
      <head>
        <meta http-equiv='content-type' content='text/html;charset=UTF-8' />
        <title>Bug in rum or Sablono ?</title>
      </head>
      <body>
        <div id='app'>"(rum/render-html (ui/simple))"</div>
        <script type='application/javascript' src='target/main.js'></script>
      </body>
    </html>"))

(defn -main [& args]
  (spit "index.html" page))
