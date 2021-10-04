<?php

namespace vanci_core\entities;

use vanci_core\libs\Globals;

/*

                                            SCHEMA

file:///C:\xampp\htdocs\vanci\vanci_db\schema\tag.sql

 */

class TagData
{


     /**
      * @var int
      */
     public $tagId;

     /**
      * @var string
      */
     public $tagName;

     /**
      * @var string
      */
      public $tagLastModificationDateTime;

      
     /**
      * @var ConversationData[]
      */
      public $conversations;

     function __construct()
     {
          
               $this->tagId = -1;
               $this->tagName = '';
               $this->conversations = array();

          
     }
}
