(require 'org-page)

(setq op/repository-directory "/home/alvaro/github/alvarogonzalezsotillo.github.io")
(setq op/repository-org-branch "draft")
(setq op/repository-html-branch "master")
(setq op/site-domain "https://alvarogonzalezsotillo.github.io/")
;;; for commenting, you can choose either disqus, duoshuo or hashover
(setq op/personal-disqus-shortname "alvarogonzalezsotillo")
(setq op/hashover-comments nil)

(setq op/personal-github-link "https://github.com/alvarogonzalezsotillo")



(setq op/personal-avatar "/media/img/octaedron.png" )
(setq op/theme-root-directory "/home/alvaro/github/alvarogonzalezsotillo.github.io/themes/")
(setq op/theme 'alvaro)

(setq op/site-main-title "Álvaro González Sotillo")
(setq op/site-sub-title "")

;;; the configuration below are optional
;(setq op/personal-google-analytics-id "your_google_analytics_id")

;; TRAS LA CONFIGURACIÓN, GENERO EL SITIO DE PRUEBA
(op/do-publication-and-preview-site op/site-preview-directory)
