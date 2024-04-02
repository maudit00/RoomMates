import { iUser } from "./iUser"

  export interface iPages {
    totalElements: number
    totalPages: number
    size: number
    content: iUser[]
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

