import { iBills } from "./iBills"
import { iShifts } from "./iShifts"
import { iUser } from "./iUser"

  export interface iPagesUser extends iPages {
  content:iUser[]
  }
  export interface iPagesBills extends iPages {
  content:iBills[]
  }
  export interface iPagesShifts extends iPages {
  content:iShifts[]
  }
  export interface iPages{
    totalElements: number
    totalPages: number
    size: number
    number: number
    sort: Sort
    numberOfElements: number
    pageable: Pageable
    first: boolean
    last: boolean
    empty: boolean
  }

  export interface Sort {
    empty: boolean
    sorted: boolean
    unsorted: boolean
  }

  export interface Pageable {
    pageNumber: number
    pageSize: number
    sort: Sort2
    offset: number
    paged: boolean
    unpaged: boolean
  }

  export interface Sort2 {
    empty: boolean
    sorted: boolean
    unsorted: boolean
  }

