#lang racket

(define RotateRight (lambda (x) (append (list-tail x 1) (list (list-ref x 0)))))

(RotateRight '(a b c d e f g))