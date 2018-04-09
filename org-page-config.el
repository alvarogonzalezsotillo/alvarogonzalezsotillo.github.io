

(defvar raiz-de-blog "/home/alvaro/alvarogonzalezsotillo.github.io")

(defun configura-blog()
  (interactive)

  (require 'org-page)

  (setq op/repository-directory raiz-de-blog)
  (setq op/repository-org-branch "source")
  (setq op/repository-html-branch "master")
  (setq op/site-domain "https://alvarogonzalezsotillo.github.io/")

  ;;; for commenting, you can choose either disqus, duoshuo or hashover
  (setq op/personal-disqus-shortname "alvarogonzalezsotillo")
  (setq op/hashover-comments nil)

  (setq op/personal-github-link "https://github.com/alvarogonzalezsotillo")

  (setq op/personal-avatar "/media/img/octaedron.png" )
  (setq op/theme-root-directory (concat raiz-de-blog "/themes/") )
  (setq op/theme 'alvaro)

  (setq op/site-main-title "Álvaro González Sotillo")
  (setq op/site-sub-title ""))



(defun generar-blog()
  (interactive)

  (configura-blog)
  ;; TRAS LA CONFIGURACIÓN, GENERO EL SITIO DE PRUEBA
  (op/do-publication-and-preview-site op/site-preview-directory))
