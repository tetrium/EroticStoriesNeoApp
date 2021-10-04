<?php

namespace vanci_core\entities;

use vanci_core\libs\Globals;

/*

                                            SCHEMA

file:///C:\xampp\htdocs\vanci\vanci_db\schema\language.sql

 */

class LanguageData
{


     /**
      * @var int
      */
     public $languageId;

     
      /**
      * @var string
      */
      public $languageCode;
     /**
      * @var string
      */
     public $languageName;
      /**
      * @var string
      */
      public $languageDisplayName;
     
      

     function __construct()
     {
      
     }
}
