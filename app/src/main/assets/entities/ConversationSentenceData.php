<?php

namespace vanci_core\entities;

use vanci_core\libs\Common;

/*

                                            SCHEMA

file:///C:\xampp\htdocs\vanci\vanci_db\schema\conversation_sentence.sql

 */

class ConversationSentenceData
{


     /**
      * @var int
      */
     public $conversationSentenceId;


     /**
      * @var int
      */
     public $conversationId;


     /**
      * @var string
      */
     public $conversationSentenceNumber;

     /**
      * @var string
      */
     public $conversationSentenceContent;
     
   /**
      * @var string
      */
      public $conversationSentenceContentTranslated;
    /**
      * @var string
      */
      public $conversationSentenceSender;


      
    /**
      * @var string
      */
      public $lastModificationDatetime;

      
     public static function getInstance($object): ConversationSentenceData
     {

          if ($object != null)
               $object = Common::stdClassToClass($object, "vanci_core\\entities\\ConversationSentenceData");
          else
               $object = new ConversationSentenceData();
          return $object;
     }
     function __construct()
     {
    //      $this->conversationSentenceExercises = array();
     //     $this->conversationSentenceLanguageTranslations = array();
          $this->conversationSentenceContentTranslated = "";
     }
}
